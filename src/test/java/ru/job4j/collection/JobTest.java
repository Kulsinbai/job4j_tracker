package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(
                new Job("Design", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("Layout", 2),
                new Job("Design", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Call up", 3),
                new Job("Call up", 8)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Release", 9),
                new Job("Prototype", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByNameAscByPriority() {
        Comparator<Job> cmp = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 2),
                new Job("Impl task", 5)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByNameDescByPriority() {
        Comparator<Job> cmp = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Design", 3),
                new Job("Design", 9)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}