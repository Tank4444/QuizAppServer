package ru.chuikov.service;


import org.springframework.stereotype.Service;
import ru.chuikov.entity.File;

import java.util.List;

public interface FileService extends CommonService<File> {

    void addFile(byte[] bytes,Long idUser);
    void addFile(byte[] bytes,Long idUser,String meta);

    void editMetaData(Long id, String meta);

    void deleteFile(Long id);

    List<File> getListFilesByUserId(Long userId);
}
