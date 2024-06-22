package me.tejaswan.bookmyshow_notifier.repository;

import me.tejaswan.bookmyshow_notifier.entity.UserRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRequestRepository extends CrudRepository<UserRequest, UUID> {
    Optional<UserRequest> findFirstByChatIdAndDateAndMovieCodeAndVenueCode(int chatId, Date date, String movieCode, String venueCode);
    List<UserRequest> findByChatId(int chatId);
}
