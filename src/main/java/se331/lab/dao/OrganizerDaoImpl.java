package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .organizationName("Animal Welfare Society")
                .address("123 Pet Street, Meow Town, MT 12345")
                .build());

        organizerList.add(Organizer.builder()
                .id(2L)
                .organizationName("Green Community Foundation")
                .address("456 Garden Avenue, Flora City, FC 67890")
                .build());

        organizerList.add(Organizer.builder()
                .id(3L)
                .organizationName("Environmental Action Group")
                .address("789 Ocean Drive, Playa Del Carmen, PDC 11111")
                .build());

        organizerList.add(Organizer.builder()
                .id(4L)
                .organizationName("Canine Rescue Network")
                .address("321 Dog Lane, Woof Town, WT 22222")
                .build());

        organizerList.add(Organizer.builder()
                .id(5L)
                .organizationName("Food Bank Alliance")
                .address("654 Hunger Road, Tin City, TC 33333")
                .build());

        organizerList.add(Organizer.builder()
                .id(6L)
                .organizationName("Highway Cleanup Initiative")
                .address("987 Highway 50, Clean City, CC 44444")
                .build());

        organizerList.add(Organizer.builder()
                .id(7L)
                .organizationName("Youth Development Center")
                .address("147 Education Boulevard, Learning City, LC 55555")
                .build());

        organizerList.add(Organizer.builder()
                .id(8L)
                .organizationName("Senior Care Foundation")
                .address("258 Wisdom Street, Elder Town, ET 66666")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        int lastIndex = Math.min(firstIndex + pageSize, organizerList.size());
        
        if (firstIndex >= organizerList.size()) {
            return new ArrayList<>();
        }
        
        return organizerList.subList(firstIndex, lastIndex);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream()
                .filter(organizer -> organizer.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
