package ru.pochinka.pet.project.bankproject.service

import ru.pochinka.pet.project.bankproject.entity.CountEntity
import ru.pochinka.pet.project.bankproject.mapper.CountEntityToDtoMapper
import ru.pochinka.pet.project.bankproject.repository.CountRepository
import spock.lang.Specification

class CountServiceTest extends Specification{

    def countRepository = Mock(CountRepository)
    def countMapper = Mock(CountEntityToDtoMapper)

    def service = new CountService(countRepository, countMapper)

    def "getByCount"() {
        setup:
        def count = new CountEntity()
        def countStr = "123456789123456789"
        def countNumeric = (BigInteger) 123456789123456789
        and:
        countRepository.findByCount(countNumeric) >> Optional.of(count)
        when:
        service.getByCount(countStr)
        then:
        1 * countMapper.sourceToDestination(count)
    }
}
