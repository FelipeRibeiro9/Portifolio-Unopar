package br.com.portifoliounopar.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portifoliounopar.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
