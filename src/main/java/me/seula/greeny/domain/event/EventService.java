package me.seula.greeny.domain.event;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.company.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final CompanyRepository companyRepository;

    public List<EventEntity> getEventList() {
        return eventRepository.findAll();
    }

    public EventEntity getEvent(int eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Entity Not Found : " + eventId));
    }

    public void createEvent(EventDTO eventDTO) {
        eventRepository.save(EventEntity.builder()
                .eventName(eventDTO.getEventName())
                .eventDesc(eventDTO.getEventDesc())
                .company(companyRepository.findById(eventDTO.getCompanyId())
                        .orElse(null))
                .build()
        );
    }
}
