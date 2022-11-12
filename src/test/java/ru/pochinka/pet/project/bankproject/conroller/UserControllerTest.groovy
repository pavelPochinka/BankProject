package ru.pochinka.pet.project.bankproject.conroller

import ru.pochinka.pet.project.bankproject.dto.request.RequestUpdateUserDto
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto
import ru.pochinka.pet.project.bankproject.facade.UserFacade
import spock.lang.Specification

class UserControllerTest extends Specification {

    def userFacade = Mock(UserFacade)

    def controller = new UserController(userFacade)

    def "Add"() {
        setup:
        def user = new RequestUserDto()
        when:
        controller.add(user)
        then:
        1 * userFacade.save(user)
    }

    def "Delete"() {
        setup:
        def id = "3422b448-2460-4fd2-9183-8000de6f8343"
        when:
        controller.delete(id)
        then:
        1 * userFacade.delete(id)
    }

    def "update"(){
        setup:
        def updateUser = new RequestUpdateUserDto()
        when:
        controller.update(updateUser)
        then:
        1 * userFacade.update(updateUser)
    }

    def "getById"(){
        setup:
        def id = "3333b448-2460-4fd2-9183-8000de6f8333"
        when:
        controller.getById(id)
        then:
        1 * userFacade.getById(id)
    }
}
