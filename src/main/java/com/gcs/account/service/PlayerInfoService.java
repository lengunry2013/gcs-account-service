package com.gcs.account.service;

import com.gcs.account.dao.PlayerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerInfoService {
    @Autowired
    PlayerInfoMapper playerInfoMapper;

    public boolean checkPlayIDExistence(String playerID) {
        return playerInfoMapper.checkPlayIDExistence(playerID);
    }

    public void createPlayInfo(String playerID, int state) {
        playerInfoMapper.createPlayInfo(playerID, state);
    }
}
