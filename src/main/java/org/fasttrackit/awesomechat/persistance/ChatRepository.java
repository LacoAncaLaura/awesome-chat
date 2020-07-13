package org.fasttrackit.awesomechat.persistance;

import org.fasttrackit.awesomechat.domain.Chat;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ChatRepository implements JpaRepository<Chat, Long> {
    @Override
    public List<Chat> findAll() {
        return null;
    }

    @Override
    public List<Chat> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Chat> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Chat> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Chat chat) {

    }

    @Override
    public void deleteAll(Iterable<? extends Chat> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Chat> S save(S s) {
        return null;
    }

    @Override
    public <S extends Chat> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Chat> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Chat> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Chat> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Chat getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Chat> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Chat> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Chat> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Chat> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Chat> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Chat> boolean exists(Example<S> example) {
        return false;
    }
}
