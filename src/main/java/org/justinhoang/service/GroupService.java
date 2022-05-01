package org.justinhoang.service;

import org.justinhoang.entity.Group;
import org.justinhoang.exception.ResourceNotFoundException;

import java.util.List;

/**
 * The interface Group service.
 */
public interface GroupService
{
    /**
     * Create group.
     *
     * @param group
     *         the group
     */
    void createGroup(Group group);

    /**
     * Read group group.
     *
     * @param id
     *         the id
     *
     * @return the group
     *
     * @throws ResourceNotFoundException
     *         the resource not found exception
     */
    Group readGroup(Long id) throws ResourceNotFoundException;

    /**
     * Read groups list.
     *
     * @return the list
     */
    List<Group> readGroups();

    /**
     * Update group.
     *
     * @param group
     *         the group
     */
    void updateGroup(Group group);

    /**
     * Delete group.
     *
     * @param id
     *         the id
     *
     * @throws ResourceNotFoundException
     *         the resource not found exception
     */
    void deleteGroup(Long id) throws ResourceNotFoundException;
}