package bg.musicapp.musicdb.service;

import bg.musicapp.musicdb.model.service.LogServiceModel;

import java.util.List;

public interface LogService {
    void createLog(String action, Long albumId);

    List<LogServiceModel> findAllLogs();
}
