package com.example.mini_P.Repository;

import com.example.mini_P.Entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NotesEntity,Long> {
    NotesEntity getNotesById(Long id);
}
