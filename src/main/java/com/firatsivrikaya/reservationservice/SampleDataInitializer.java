package com.firatsivrikaya.reservationservice;

import com.firatsivrikaya.reservationservice.model.Reservation;
import com.firatsivrikaya.reservationservice.repository.IReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class SampleDataInitializer {

    private final IReservationRepository reservationRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        Flux<String> names = Flux.just("Firat", "Josh", "John", "James");
        Flux<Reservation> reservations = names.map(name -> new Reservation(null, name));
        Flux<Reservation> saved = reservations.flatMap(reservationRepository::save);
    }
}
