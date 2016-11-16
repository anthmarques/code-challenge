package main.service;

import main.model.Property;
import main.model.ProvinceEnum;
import main.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.Pageable;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    public Property save(Property property) {
        property = this.repository.save(property);
        property.setProvinces(this.defineProvince(property));

        return property;
    }

    public Property get(long id) {
        Property property = new Property();
        property = this.repository.findOne(id);
        property.setProvinces(this.defineProvince(property));

        return property;
    }

    public Iterable<Property> search(int ax, int ay, int bx, int by, Pageable p) {
        Iterable<Property> properties;

        properties = this.repository.findByLocation(ax,ay,bx,by, p);
        properties.forEach(
            (Property property) -> property.setProvinces(this.defineProvince(property))
        );

        return properties;
    }

    private ArrayList<String> defineProvince(Property property) {
        int x = property.getX();
        int y = property.getY();
        ArrayList<String> provinces = new ArrayList<String>();

        for (ProvinceEnum province : ProvinceEnum.values() ) {
            if ( (x >= province.getUpperLeftX() && x <= province.getUpperLeftY()) &&
                 (y <= province.getBottomRightX() && y >= province.getBottomRightY())
             ) {
                provinces.add(province.getName());
            }
        }

        return provinces;
    }


}
