package com.example.touristguideapi.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {

    //Arrange
    TouristRepository tr = new TouristRepository();

    @Test
    void getDescription() {
        //Act
        String expectedResult = "Bornholms kyststi (ca. 115 km). Du kommer gennem både større og mindre byer på Bornholm, men det meste af turen foregår i uforstyrret natur med en utrolig flot udsigt.";
        String actualResult = tr.getDescription("Bornholms Kyststi");

        //Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void updateAttraction() {
        //Act
        tr.updateAttraction("bornholms kyststi", "Opdateret beskrivelse");

        String expectedResult = "Opdateret beskrivelse";
        String actualResult = tr.getDescription("bornholms kyststi");
        //Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }
}