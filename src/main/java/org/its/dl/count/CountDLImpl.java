package org.its.dl.count;

import javax.inject.Named;

@Named("countDL")
public class CountDLImpl implements CountDL {
    int enabled = 0;

    @Override
    public void incrementEnabled() {
        enabled++;
    }

    @Override
    public void decrementEnabled() {
        enabled--;
    }

    @Override
    public int getEnabled() {
        return enabled;
    }
}
