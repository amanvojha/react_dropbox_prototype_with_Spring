package com.dropbox_demo.dropbox_spring_server.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;

public interface FilesFoldersRepository extends MongoRepository<dropbox_userfiles, Long>{

	List<dropbox_userfiles> findByParentId(String parentId);
}
