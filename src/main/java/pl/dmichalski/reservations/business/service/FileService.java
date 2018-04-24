package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.File;
import pl.dmichalski.reservations.business.repository.FileRepository;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public List<File> getFilesForCurrentUser() {
        return fileRepository.findAllByUserEquals(UserService.currentUser);
    }

    public void deleteFile(File file) {
        fileRepository.delete(file);
    }

    public File saveFile(File file) {
        return fileRepository.save(file);
    }
}
