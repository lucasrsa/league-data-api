package com.github.lucasrsa.leaguedataapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@Getter
@AllArgsConstructor
public abstract class Tagged {
    @NonNull
    protected final String tag;
    @NonNull
    protected final String name;
    @NonNull
    protected final String region;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tagged tagged = (Tagged) o;
        return tag.equalsIgnoreCase(tagged.tag) && region.equalsIgnoreCase(tagged.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, region);
    }
}
