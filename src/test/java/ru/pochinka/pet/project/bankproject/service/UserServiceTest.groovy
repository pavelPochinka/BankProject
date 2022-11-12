package ru.pochinka.pet.project.bankproject.service

import ru.pochinka.pet.project.bankproject.entity.UserEntity
import ru.pochinka.pet.project.bankproject.repository.UserRepository
import spock.lang.Specification

class UserServiceTest extends Specification{

    def userRepository = Mock(UserRepository)

    def service = new UserService(userRepository)

    def "save"(){
        setup:
        def user = new UserEntity()
        when:
        service.save(user)
        then:
        1 * userRepository.save(user)
    }


    def "deleteUserById"(){
        setup:
        def id = UUID.randomUUID()
        when:
        service.deleteUserById(id)
        then:
        1 * userRepository.deleteByObjectId(id)
    }

}
