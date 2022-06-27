package ru.chuikov.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.chuikov.entity.ar.File;
import ru.chuikov.entity.actor.User;
import ru.chuikov.repository.ar.FileRepository;
import ru.chuikov.repository.actor.UserRepository;
import ru.chuikov.service.FileService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Log4j2
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(File file) {
            fileRepository.saveAndFlush(file);
    }

    @Override
    public File getById(Long id) {
        return fileRepository.getById(id);
    }

    @Override
    public void updateById(File file) {
        fileRepository.saveAndFlush(file);
    }

    @Override
    public void deleteById(Long id) {
        fileRepository.deleteById(id);
    }

    @Override
    public void deleteById(File file) {
        fileRepository.deleteById(file.getId());
    }

    @Override
    public Collection<File> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public void addFile(byte[] bytes, Long id) {
        User user = userRepository.getByID(id);
        if(user == null) throw new UsernameNotFoundException("User not found");

        fileRepository.saveAndFlush(File.builder()
                .bytes(bytes)
                .creator(user)
                .meta("")
                        .creator(user)
                .build());
    }

    @Override
    public void addFile(byte[] bytes, Long id, String meta) {
        User user = userRepository.getByID(id);
        if(user == null) throw new UsernameNotFoundException("User not found");
        fileRepository.saveAndFlush(File.builder()
                .bytes(bytes)
                .creator(user)
                .meta("")
                .creator(user)
                .build());
    }

    @Override
    public void editMetaData(Long id, String meta) throws Exception {
        var file1 = fileRepository.findById(id);
        if(file1.isEmpty()) throw new Exception("File with id "+id+" not found");
        var file = file1.get();
        file.setMeta(meta);
        fileRepository.saveAndFlush(file);
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }

    @Override
    public List<File> getListFilesByUserId(Long userId) {
        return fileRepository.findAllByUserId(userId);
        //return null;
    }
}
