package lazzy.web.controller;

import lazzy.web.service.RoleService;
import lazzy.web.service.UserDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class RoleController {
    private final RoleService roleService;
    private final UserDao userDao;

    public RoleController(RoleService roleService, UserDao userDao) {
        this.roleService = roleService;
        this.userDao = userDao;

    }

    @GetMapping("/assign-role")
    public String showAssignRolePage(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        return "assignRole";
    }

    @PostMapping("/assign-role")
    public String assignRole(@RequestParam("userId") Long userId, @RequestParam("roleId") Long roleId) {
        roleService.assignRole(userId, roleId);
        return "redirect:/assign-role";
    }

    @PostMapping("/remove-role")
    public String removeRole(@RequestParam("userId") Long userId, @RequestParam("roleId") Long roleId) {
        roleService.removeRole(userId, roleId);
        return "redirect:/assign-role";
    }
}
