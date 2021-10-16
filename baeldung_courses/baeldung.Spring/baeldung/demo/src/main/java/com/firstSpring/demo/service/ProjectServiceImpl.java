package com.firstSpring.demo.service;
/*
** code blocked to add new folder implementation
 */

/*
import com.firstSpring.demo.persistence.model.Project;
import com.firstSpring.demo.persistence.repository.IProjectRepository;

import java.util.Optional;

// @Service
public class ProjectServiceImpl implements IProjectService {

//    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);


    private IProjectRepository projectRepo;

 */
/*   public ProjectServiceImpl(@Qualifier("projectRepositoryImpl") IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
        System.out.println("constructor ProjectServiceImp");
    }
*//*


    public ProjectServiceImpl(IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
 //       LOG.debug("Project Service >> Finding Project by Id " + id);
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
//        LOG.debug("Project Service >> Saving Project" + project);
        return projectRepo.save(project);
    }

    public IProjectRepository getProjectRepo() {
        return projectRepo;
    }

    public void setProjectRepo(IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }
}
*/
