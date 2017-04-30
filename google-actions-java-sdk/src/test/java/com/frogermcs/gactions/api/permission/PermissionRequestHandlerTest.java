package com.frogermcs.gactions.api.permission;

import com.frogermcs.gactions.api.request.Location;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.request.UserProfile;
import com.frogermcs.gactions.api.response.RootResponse;
import com.frogermcs.gactions.testUtils.TestObjects;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by froger_mcs on 30/04/2017.
 */
public class PermissionRequestHandlerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPermission_shouldReturnGrantedPermission() throws Exception {
        RootRequest rootRequest = TestObjects.permissionGrantedRequest(true);

        PermissionRequestHandler permissionRequestHandler = new PermissionRequestHandler(rootRequest) {
            @Override
            public RootResponse getResponse() {
                return new RootResponse();
            }
        };

        assertTrue(permissionRequestHandler.isPermissionGranted());
    }

    @Test
    public void testPermission_shouldReturnNotGrantedPermission() throws Exception {
        RootRequest rootRequest = TestObjects.permissionGrantedRequest(false);

        PermissionRequestHandler permissionRequestHandler = new PermissionRequestHandler(rootRequest) {
            @Override
            public RootResponse getResponse() {
                return new RootResponse();
            }
        };

        assertFalse(permissionRequestHandler.isPermissionGranted());
    }

    @Test
    public void testPermission_whenPermissionIsNotGranted_thenShouldntReturnUserProfile() throws Exception {
        RootRequest rootRequest = TestObjects.permissionGrantedUserProfileRequest(false);
        PermissionRequestHandler permissionRequestHandler = new PermissionRequestHandler(rootRequest) {
            @Override
            public RootResponse getResponse() {
                return new RootResponse();
            }
        };

        assertNull(permissionRequestHandler.getUserProfile());
    }

    @Test
    public void testPermission_whenPermissionIsGranted_thenShouldReturnUserProfile() throws Exception {
        RootRequest rootRequest = TestObjects.permissionGrantedUserProfileRequest(true);
        PermissionRequestHandler permissionRequestHandler = new PermissionRequestHandler(rootRequest) {
            @Override
            public RootResponse getResponse() {
                return new RootResponse();
            }
        };

        UserProfile userProfile = permissionRequestHandler.getUserProfile();
        assertNotNull(userProfile);
        assertEquals(rootRequest.user.profile, userProfile);
    }

    @Test
    public void testPermission_whenPermissionIsNotGranted_thenShouldntReturnLocation() throws Exception {
        RootRequest rootRequest = TestObjects.permissionGrantedLocationRequest(false);
        PermissionRequestHandler permissionRequestHandler = new PermissionRequestHandler(rootRequest) {
            @Override
            public RootResponse getResponse() {
                return new RootResponse();
            }
        };

        assertNull(permissionRequestHandler.getLocation());
    }

    @Test
    public void testPermission_whenPermissionIsGranted_thenShouldReturnLocation() throws Exception {
        RootRequest rootRequest = TestObjects.permissionGrantedLocationRequest(true);
        PermissionRequestHandler permissionRequestHandler = new PermissionRequestHandler(rootRequest) {
            @Override
            public RootResponse getResponse() {
                return new RootResponse();
            }
        };

        Location location = permissionRequestHandler.getLocation();
        assertNotNull(location);
        assertEquals(rootRequest.device.location, location);
    }

}