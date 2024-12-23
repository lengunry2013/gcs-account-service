package com.gcs.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlayerInfoMapper {
    boolean checkPlayIDExistence(String playerID);

    void createPlayInfo(String playerID,int state);

}
