package main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import main.model.Property;
import main.service.PropertyService;
import java.lang.Iterable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private PropertyService service;

    @Autowired
    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Property add(@RequestBody Property property) {
          return this.service.save(property);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Property> get(@PathVariable long id) {
        try {
            Property property;
            property = this.service.get(id);

            return new ResponseEntity<Property>(property, HttpStatus.OK);

        } catch (NullPointerException e) {
            ArrayList<String> emptyResponse = new ArrayList<String>();
            return new ResponseEntity(emptyResponse, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Iterable<Property> search(@RequestParam("ax") int ax,
            @RequestParam("ay") int ay,
            @RequestParam("bx") int bx,
            @RequestParam("by") int by,
            Pageable pageable
        ) {


        return this.service.search(ax, ay, bx, by, pageable);
    }
}
