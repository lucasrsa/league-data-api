package com.github.lucasrsa.leaguedataapi.domain;

import lombok.NonNull;

public class Team extends Tagged {
    public Team(@NonNull String tag, @NonNull String name, @NonNull String region) {
        super(tag, name, region);
    }
}
