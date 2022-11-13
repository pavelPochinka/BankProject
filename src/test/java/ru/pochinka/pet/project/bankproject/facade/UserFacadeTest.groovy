package ru.pochinka.pet.project.bankproject.facade

import ru.pochinka.pet.project.bankproject.dto.CardDto
import ru.pochinka.pet.project.bankproject.dto.request.RequestUpdateUserDto
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto
import ru.pochinka.pet.project.bankproject.entity.CardEntity
import ru.pochinka.pet.project.bankproject.entity.UserEntity
import ru.pochinka.pet.project.bankproject.enums.UserResponse
import ru.pochinka.pet.project.bankproject.facade.impl.UserFacadeImpl
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper
import ru.pochinka.pet.project.bankproject.mapper.UserEntityToDtoMapper
import ru.pochinka.pet.project.bankproject.service.CardService
import ru.pochinka.pet.project.bankproject.service.UserService
import spock.lang.Specification

class UserFacadeTest extends Specification {

    def userService = Mock(UserService)
    def userMapper = Mock(UserEntityToDtoMapper)
    def cardService = Mock(CardService)
    def cardMapper = Mock(CardEntityToDtoMapper)

    def facade = new UserFacadeImpl(userService, userMapper, cardService, cardMapper)


    def "Save"() {
        setup:
        def user = new UserEntity(objectId: UUID.randomUUID())
        def cardDto = new CardDto(cardNumber: 123)
        def card = new CardEntity()
        def requestUserDto = new RequestUserDto(cards: [cardDto])
        and:
        userMapper.destinationToSource(requestUserDto) >> user
        userService.save(user) >> user
        cardMapper.destinationToSource(cardDto) >> card

        when:
        def result = facade.save(requestUserDto)
        then:
        1 * cardService.save(card)
        card.userId == user.objectId
        result.message == UserResponse.SUCCESSFUL_CREATING.getMessage()
    }

    def "Delete"() {
        setup:
        def idStr = "3422b448-2460-4fd2-9183-8000de6f8343"
        and:
        def uuid = UUID.fromString(idStr)
        when:
        facade.delete(idStr)
        then:
        1 * userService.deleteUserById(uuid)
    }

    def "getById"(){
        setup:
        def id = "3333b448-2460-4fd2-9183-8000de6f8333"
        def uuidId = UUID.fromString(id)
        def userEntity = new UserEntity(objectId: uuidId)
        and:
        userService.getUserById(uuidId) >> userEntity
        when:
        facade.getById(id)
        then:
        1 * userMapper.sourceToDestination(userEntity)
    }

    def "update"() {
        setup:
        def uuidId = UUID.randomUUID()
        def updateUser = new RequestUpdateUserDto(userId: uuidId, firstName: "Arseniy", secondName: "Pochinka")
        def userEntity = new UserEntity()
        and:
        userService.getUserById(uuidId) >> userEntity
        when:
        facade.update(updateUser)
        then:
        1 * userService.save(userEntity)

    }
}
