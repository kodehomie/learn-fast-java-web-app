package org.justinhoang.service;

import org.justinhoang.entity.Group;
import org.justinhoang.exception.ResourceNotFoundException;
import org.justinhoang.persistence.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Group service imp.
 */
@Service
public class GroupServiceImp implements GroupService
{
    @Autowired
    private GroupRepo groupRepo;

    @Override
    @Transactional
    public void createGroup(final Group group)
    {
        groupRepo.save(group);
    }

    @Override
    @Transactional
    public Group readGroup(final Long id) throws ResourceNotFoundException
    {
        return groupRepo.findById(id)
                       .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public List<Group> readGroups()
    {
        return (List<Group>) groupRepo.findAll();
    }

    @Override
    @Transactional
    public void updateGroup(final Group group)
    {
        groupRepo.save(group);
    }

    @Override
    @Transactional
    public void deleteGroup(final Long id)
    {
        groupRepo.deleteById(id);
    }
}
