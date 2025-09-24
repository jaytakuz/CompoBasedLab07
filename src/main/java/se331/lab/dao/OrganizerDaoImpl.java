package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("Animal Welfare Society")
                .description("Improving the wellbeing of domestic animals across the region")
                .contactEmail("contact@awsociety.org")
                .build());

        organizerList.add(Organizer.builder()
                .id(2L)
                .name("Green Community Foundation")
                .description("Community-driven projects that focus on urban gardening and sustainability")
                .contactEmail("hello@greencommunity.org")
                .build());

        organizerList.add(Organizer.builder()
                .id(3L)
                .name("Environmental Action Group")
                .description("Grassroots organization organizing coastal cleanup events")
                .contactEmail("team@eagroup.org")
                .build());

        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Canine Rescue Network")
                .description("Rescuing and rehabilitating stray dogs before adoption")
                .contactEmail("support@caninerescue.net")
                .build());

        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Food Bank Alliance")
                .description("Coordinating food donations for low-income families")
                .contactEmail("info@foodbankalliance.org")
                .build());

        organizerList.add(Organizer.builder()
                .id(6L)
                .name("Highway Cleanup Initiative")
                .description("Volunteer group keeping major commuter routes free from litter")
                .contactEmail("cleanup@highwayinitiative.org")
                .build());

        organizerList.add(Organizer.builder()
                .id(7L)
                .name("Youth Development Center")
                .description("After-school programs supporting teens with tutoring and mentorship")
                .contactEmail("office@youthdevcenter.org")
                .build());

        organizerList.add(Organizer.builder()
                .id(8L)
                .name("Senior Care Foundation")
                .description("Providing companionship and assistance to elderly residents")
                .contactEmail("care@seniorfoundation.org")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        int lastIndex = Math.min(firstIndex + pageSize, organizerList.size());
        
        if (firstIndex >= organizerList.size()) {
            return new PageImpl<>(new ArrayList<>(), PageRequest.of(page - 1, pageSize), organizerList.size());
        }
        
        List<Organizer> pageContent = organizerList.subList(firstIndex, lastIndex);
        return new PageImpl<>(pageContent, PageRequest.of(page - 1, pageSize), organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream()
                .filter(organizer -> organizer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId((long) (organizerList.size() + 1));
        organizerList.add(organizer);
        return organizer;
    }
}
