package de.telran.onlineshop.service;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.AddressEntity;
import de.telran.onlineshop.entity.CartEntity;
import de.telran.onlineshop.entity.FavoritesEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Role;
//import de.telran.onlineshop.mapper.Mappers;
import de.telran.onlineshop.mapper.UserMapper;
import de.telran.onlineshop.repository.CartRepository;
import de.telran.onlineshop.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock // object , povedenie kot.budem imitieren
    private UsersRepository usersRepositoryMock;

    @Mock
    private CartRepository cartRepositoryMock;

    @Mock
//    private Mappers mappersMock;
    private UserMapper mappersMock;

    @InjectMocks
    private UsersService usersServiceTest;//object for testing - unit object

    private UsersEntity userEntityTest1;

    private UserDto userDtoTest1;

    @BeforeEach
    void setUp() {

        userEntityTest1 = new UsersEntity(
                1L,
                "Vasja Pupkin",
                "rrr@web.de",
                "+491601234567",
                "Password1",
                Role.CLIENT,
                new CartEntity(),
                new HashSet<FavoritesEntity>(),
                new HashSet<AddressEntity>()
        );

        userDtoTest1 = new UserDto(
                1L,
                "Vasja Pupkin",
                "rrr@web.de",
                "+491601234567",
                "Password1"

        );
    }

    @Test
    void getAllUsersTest() {

        UsersEntity userEntityTest2 = new UsersEntity(
                2L,
                "Dunja Smirnova",
                "rrr@mail.de",
                "+49160765432",
                "Password2",
                Role.ADMIN,
                new CartEntity(),
                new HashSet<FavoritesEntity>(),
                new HashSet<AddressEntity>()
        );


        UserDto userDtoTest2 = new UserDto(
                2L,
                "Dunja Smirnova",
                "rrr@mail.de",
                "+49160765432",
                "Password2"

        );

        when(usersRepositoryMock.findAll()).thenReturn(List.of(userEntityTest1, userEntityTest2));
        when(mappersMock.convertToUserDto(userEntityTest1)).thenReturn(userDtoTest1);
        when(mappersMock.convertToUserDto(userEntityTest2)).thenReturn(userDtoTest2);

        List<UserDto> actualUserDtoList = usersServiceTest.getAllUsers();

        //proverka
        assertNotNull(actualUserDtoList);
        assertTrue(actualUserDtoList.size() > 0);
        assertEquals(2, actualUserDtoList.size());
        assertEquals(2, actualUserDtoList.get(0).getUserID());
        assertEquals(userDtoTest2, actualUserDtoList.get(0));
        verify(usersRepositoryMock).findAll();//bil li sapuschen etot metod .
        verify(mappersMock, times(2)).convertToUserDto(any(UsersEntity.class));//bil li sapuschen etot metod i skolko ras

    }


    @Test
    void getUserByIdTest() {
        Long testId = 1L;
        when(usersRepositoryMock.findById(testId)).thenReturn(Optional.of(userEntityTest1));
        when(mappersMock.convertToUserDto(userEntityTest1)).thenReturn(userDtoTest1);

        UserDto actualUserDto = usersServiceTest.getUserById(testId);

        assertNotNull(actualUserDto);
        assertEquals(testId, actualUserDto.getUserID());
        assertEquals(userDtoTest1, actualUserDto);
        verify(usersRepositoryMock).findById(testId);
        verify(mappersMock, times(1)).convertToUserDto(any(UsersEntity.class));


    }

    @Test
    void updateUserTest() {




        when(mappersMock.convertToUserEntity(userDtoTest1)).thenReturn(userEntityTest1);
        when(usersRepositoryMock.save(userEntityTest1)).thenReturn(userEntityTest1);
        when(mappersMock.convertToUserDto(userEntityTest1)).thenReturn(userDtoTest1);


        UserDto actualUserDto = usersServiceTest.updateUser(userDtoTest1);

        assertNotNull(actualUserDto);
        assertEquals(userDtoTest1.getUserID(), actualUserDto.getUserID());
        assertEquals(userDtoTest1, actualUserDto);

        verify(mappersMock).convertToUserEntity(userDtoTest1);

        verify(usersRepositoryMock).save(userEntityTest1);
        verify(mappersMock).convertToUserDto(userEntityTest1);

    }

    @Test
    void insertUsersTest() {
        UsersEntity userEntityTestInput = new UsersEntity(
                null,
                "Vasja Pupkin",
                "rrr@web.de",
                "+491601234567",
                "Password1",
                Role.CLIENT,
                new CartEntity(),
                new HashSet<FavoritesEntity>(),
                new HashSet<AddressEntity>()
        );

        UserDto userDtoTestInput = new UserDto(
                null,
                "Vasja Pupkin",
                "rrr@web.de",
                "+491601234567",
                "Password1"

        );


        when(mappersMock.convertToUserEntity(userDtoTestInput)).thenReturn(userEntityTestInput);
        when(usersRepositoryMock.save(userEntityTestInput)).thenReturn(userEntityTest1);
        when(mappersMock.convertToUserDto(userEntityTest1)).thenReturn(userDtoTest1);

        UserDto actualUserDto = usersServiceTest.insertUsers(userDtoTestInput);//sapusk realnogo metoda

        assertNotNull(actualUserDto);
        assertNotNull(actualUserDto.getUserID());
        assertNotEquals(userDtoTestInput.getUserID(), actualUserDto.getUserID());
        assertNotEquals(userDtoTestInput, actualUserDto);

        verify(mappersMock).convertToUserEntity(userDtoTestInput);

        verify(usersRepositoryMock).save(userEntityTestInput);
        verify(mappersMock).convertToUserDto(userEntityTest1);

    }

    @Test
    void deleteUsersByIdTest() {
        Long testId = 1L;
        when(usersRepositoryMock.findById(testId)).thenReturn(Optional.of(userEntityTest1));

        usersServiceTest.deleteUsersById(testId);//sapusk realnogo metoda

        verify(usersRepositoryMock).delete(userEntityTest1); // bil li sapuschen etot metod

    }

    @Test
    void initTest() {
        when(cartRepositoryMock.save(any(CartEntity.class))).thenReturn(new CartEntity());
        when(usersRepositoryMock.save(any(UsersEntity.class))).thenReturn(new UsersEntity());
        usersServiceTest.init();
        verify(cartRepositoryMock, times(2)).save(any(CartEntity.class));
        verify(usersRepositoryMock, times(2)).save(any(UsersEntity.class));
    }
}