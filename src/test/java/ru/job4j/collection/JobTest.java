package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenAscByNameTest() {
        Comparator<Job> cmpByAscName = new JobAscByName();
        int res = cmpByAscName.compare(
                new Job("Fix bug", 2),
                new Job("Impl task", 1)
        );
        assertThat(res).isLessThan(0);
    }

    @Test
    void whenDescByNameTest() {
        Comparator<Job> cmpByDescName = new JobDescByName();
        int res = cmpByDescName.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(res).isLessThan(0);
    }

    @Test
    void whenAscByPriorityTest() {
        Comparator<Job> cmpByAscPriority = new JobAscByPriority();
        int res = cmpByAscPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 2)
        );
        assertThat(res).isLessThan(0);
    }

    @Test
    void whenDescByPriorityTest() {
        Comparator<Job> cmpByDescPriority = new JobDescByPriority();
        int res = cmpByDescPriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(res).isLessThan(0);
    }

    @Test
    public void whenComporatorByDescNameAndPriority() {
        Comparator<Job> cmpDescNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int res = cmpDescNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(res).isLessThan(0);
    }

    @Test
    public void whenComporatorByAskNameAndPriority() {
        Comparator<Job> cmpAscNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int res = cmpAscNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(res).isLessThan(0);

    }
}