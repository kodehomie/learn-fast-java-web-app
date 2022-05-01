package org.justinhoang.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.Group;
import org.justinhoang.exception.ResourceNotFoundException;
import org.justinhoang.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Group controller.
 */
@Controller
@RestController
@RequestMapping("/group")
public class GroupController
{
    @Autowired
    private       GroupService groupService;
    // Logging framework
    static final Logger      logger = LogManager.getLogger();

    /**
     * Group create string.
     *
     * @param group
     *         the group
     *
     * @return the string
     */
    @PostMapping("/groupCreate")
    public String groupCreate(@ModelAttribute("group") Group group)
    {
        groupService.createGroup(group);
        return "redirect:/group/groups-read";
    }

    /**
     * Group create form string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/groupCreateForm")
    public String groupCreateForm(Model entity)
    {
        Group group = new Group();
        entity.addAttribute("group", group);
        return "group-form";
    }

    /**
     * Groups read string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/groupsRead")
    public String groupsRead(Model entity)
    {
        List<Group> groups = groupService.readGroups();
        entity.addAttribute("groups", groups);
        return "groups-read";
    }

    /**
     * Group update form string.
     *
     * @param id
     *         the id
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/groupUpdateForm")
    public String groupUpdateForm(@RequestParam("id") Long id, Model entity) throws
                                                                            ResourceNotFoundException

    {
        Group group = groupService.readGroup(id);
        entity.addAttribute("group", group);
        return "group-form";
    }

    /**
     * Group delete string.
     *
     * @param id
     *         the id
     *
     * @return the string
     */
    @GetMapping("/groupDelete")
    public String groupDelete(@RequestParam("id") Long id) throws
                                                          ResourceNotFoundException
    {
        groupService.deleteGroup(id);
        return "redirect:/group/groups-read";
    }
}
