package org.anviro.crm.backend.authentication.database.service;

import org.anviro.crm.backend.authentication.Utils;
import org.anviro.crm.backend.authentication.database.entity.Log;
import org.anviro.crm.backend.authentication.database.repository.LogRepository;
import org.anviro.crm.common.beans.authentication.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogDBService {

    @Autowired
    private LogRepository logRepository;

    public List<LogBean> getLoginLogs() {
        List<Log> dbLogs = logRepository.findAll();
        List<LogBean> logs = new ArrayList<>();
        for (Log log: dbLogs) {
            logs.add(Utils.createLogBean(log));
        }
        return logs;
    }

    @Transactional
    public void addLoginLog(Log log) {
        logRepository.save(log);
    }


}
