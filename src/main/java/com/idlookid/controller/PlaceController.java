/**
 * 
 */
package com.idlookid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.idlookid.domain.Place;
import com.idlookid.service.FileService;
import com.idlookid.service.PlaceService;
import com.idlookid.staticdata.ObjectType;

/**
 * @author quocanh
 *
 */
@RestController
@RequestMapping("/place")
public class PlaceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlaceController.class);
    private final PlaceService placeService;
    private final FileService fileService;
    
    @Autowired
    public PlaceController(final PlaceService placeService, final FileService fileService) {
        this.placeService = placeService;
        this.fileService = fileService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Place get(@PathVariable Long id) {
        LOGGER.debug("Received request to get the place with id {}", id);
        return placeService.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Place create(@ModelAttribute @Valid final Place place, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
    	place.setCreatedFromIp(request.getRemoteAddr());
        
    	LOGGER.debug("Received request to create the {}", place);
    	Place createdPlace = placeService.create(place);
    	String imagePath = fileService.saveFile(file, createdPlace.getId(), ObjectType.PLACE.getLabel());
    	place.setImagePath(imagePath);
        return placeService.update(createdPlace.getId(), createdPlace);
    }    
    
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Place update(@PathVariable Long id, @RequestBody Place place) {
    	LOGGER.debug("Received request to update the {}", place);
    	return placeService.update(id, place);    	
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable Long id) {
    	LOGGER.debug("Someone try to delete the {}", placeService.get(id));
    	//placeService.delete(id);
    }
}
