package ru.chuikov.service;


import ru.chuikov.entity.ar.File;

import java.util.List;

public interface FileService extends CommonService<File> {

    void addFile(byte[] bytes,Long idUser);
    void addFile(byte[] bytes,Long idUser,String meta);

    void editMetaData(Long id, String meta) throws Exception;

    void deleteFile(Long id);

    List<File> getListFilesByUserId(Long userId);
}
