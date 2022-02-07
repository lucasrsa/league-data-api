package com.github.lucasrsa.leaguedataapi.utils;

import com.github.lucasrsa.leaguedataapi.domain.Match;
import com.github.lucasrsa.leaguedataapi.domain.Team;
import com.github.lucasrsa.leaguedataapi.domain.Tournament;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<Tournament> loadTournaments() throws IOException {
        File file = ResourceUtils.getFile("classpath:data/tournaments.csv");
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        csvReader.readLine();
        String row;
        List<Tournament> tournamentList = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            tournamentList.add(new Tournament(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4])));
        }
        csvReader.close();
        return tournamentList;
    }

    public static void loadTeams(Tournament tournament) throws IOException {
        File file = ResourceUtils.getFile("classpath:data/" + tournament.getTag().toLowerCase() + "_teams.csv");
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        csvReader.readLine();
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            tournament.addTeam(data[0], data[1]);
        }
        csvReader.close();
    }

    public static void loadSchedule(Tournament tournament) throws IOException {
        File file = ResourceUtils.getFile("classpath:data/" + tournament.getTag().toLowerCase() + "_schedule.csv");
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        csvReader.readLine();
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            tournament.addMatch(new Match(tournament.getTeam(data[0]), tournament.getTeam(data[1]), data.length > 2 ? tournament.getTeam(data[2]) : null));
        }
        csvReader.close();
    }

}
