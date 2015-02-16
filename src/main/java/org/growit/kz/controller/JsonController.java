package org.growit.kz.controller;

import org.growit.kz.model.*;
import org.growit.kz.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 23.12.2014.
 */
@RestController
@RequestMapping("/data")
public class JsonController {

    private final MainService mainService;

    @Autowired
   public JsonController (MainService mainService) {

        this.mainService = mainService;
    }



    @RequestMapping(value = "/getCars", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody

    public List<Cars> getAllCars() {


        List<Cars> cars = mainService.getAllCars();

        return cars;
    }
//    get one car

    @RequestMapping(value = "/getCar", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Cars getOneCar(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id) {

        Cars cars = mainService.findByIdCars(id);

        return cars;
    }

    @RequestMapping(value = "/getUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Users getOneUser(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id) {

        Users user = mainService.findByIdUser(id);

        return user;
    }

    @RequestMapping(value = "/getGroup", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<GroupParts> groupPartsList() {


        List<GroupParts> groupParts= mainService.getAllGroups();

        return groupParts;

    }

    @RequestMapping(value = "/getGroupByCarID", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<GroupParts> groupPartsListByCarID(@RequestParam(value = "id",required = false,
            defaultValue = "1") Integer id) {


        List<GroupParts> groupParts= mainService.getGroupPartsByCarID(id);

        return groupParts;

    }

    @RequestMapping(value = "/getGroupWithCarID", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<GroupParts> groupPartsListWithCarID(@RequestParam(value = "id",required = false,
            defaultValue = "1") Integer id) {

        List<GroupParts> groupParts= mainService.getGroupWithCarID(id);

        return groupParts;

    }

    @RequestMapping(value = "/getSubGroupByGroupID", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<SubGroups> getSubGroupByGroupID(@RequestParam(value = "id",required = false,
            defaultValue = "1") Integer id) {

        List<SubGroups> subGroupParts= mainService.getSubGroupByGroupID(id);

        return subGroupParts;

    }

    @RequestMapping(value = "/getPartsBySubGroupID", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Parts> getPartsBySubGroupID(@RequestParam(value = "id",required = false,
            defaultValue = "1") Integer id) {

        List<Parts> Parts= mainService.getPartsBySubGroupID(id);

        return Parts;

    }



}
