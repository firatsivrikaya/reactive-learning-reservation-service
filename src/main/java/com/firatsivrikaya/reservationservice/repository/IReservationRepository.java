package com.firatsivrikaya.reservationservice.repository;

import com.firatsivrikaya.reservationservice.model.Reservation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IReservationRepository extends ReactiveCrudRepository<Reservation, String> {

}
