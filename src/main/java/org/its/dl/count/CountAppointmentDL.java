package org.its.dl.count;

public interface CountAppointmentDL {
    void incrementAppointment(int idUtente);
    void decrementAppointment(int idUtente) throws Exception;
    int getAppointment(int idUtente);
}
