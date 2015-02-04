package by.epamlab.users.service;

import by.epamlab.users.dao.EmployeeDao;
import by.epamlab.users.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class EmployeeDetailsService implements UserDetailsService{

    //get user from the database, via Hibernate
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        by.epamlab.users.model.Employee user = employeeDao.findByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);

    }

    // Converts by.epamlab.users.model.Employee user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(by.epamlab.users.model.Employee user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(UserRole userRole) {

        //Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        /*for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }*/

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>();
        Result.add(new SimpleGrantedAuthority(userRole.getName()));

        return Result;
    }
}
