package com.codemsaters.Accomodate.Me.security.auth;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codemsaters.Accomodate.Me.model.Admin;
import com.codemsaters.Accomodate.Me.model.Role;
import com.codemsaters.Accomodate.Me.repository.AdminRepository;
import com.codemsaters.Accomodate.Me.security.config.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final AdminRepository adminRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {

                // Validate Number of Rooms
                int totalRooms = request.getTotalNumberOfSingleRooms() + request.getTotalNumberOfDoubleRooms();

                if (totalRooms != request.getTotalNumberOfRooms()) {
                        throw new IllegalArgumentException(
                                        "Total number of single rooms plus total number of double rooms must be equal to the total number of rooms.");
                }

                // Validate Images

                if (request.getImages() == null || request.getImages().size() < 6 || request.getImages().size() > 6) {
                        throw new IllegalArgumentException("Number of images must be exactly 6.");
                }

                // Check Nulls in all the fields

                if (request.getEmail() == null || request.getEmail().isEmpty()) {

                        throw new IllegalArgumentException("Invalid Email address");
                }

                if (request.getFullname() == null || request.getFullname().isEmpty()) {
                        throw new IllegalArgumentException("Invalid Fullname");
                }
                if (request.getPassword() == null || request.getPassword().isEmpty()) {
                        throw new IllegalArgumentException("Invalid Password");
                }
                if (request.getName() == null || request.getName().isEmpty()) {
                        throw new IllegalArgumentException("Invalid Residence Name");
                }
                if (request.getSlogan() == null || request.getSlogan().isEmpty()) {
                        throw new IllegalArgumentException("Invalid Slogan");
                }
                if (request.getRegNo() == 0) {
                        throw new IllegalArgumentException("Invalid Registration Number");
                }
                if (request.getPhoneNumber() == null || request.getName().isEmpty()) {
                        throw new IllegalArgumentException("Invalid Phone Number");
                }
                if (request.getTotalNumberOfRooms() == 0) {
                        throw new IllegalArgumentException("Invalid total number of rooms");
                }
                if (request.getTotalNumberOfSingleRooms() == 0) {
                        throw new IllegalArgumentException("Invalid total number of single rooms");
                }
                if (request.getTotalNumberOfDoubleRooms() == 0) {
                        throw new IllegalArgumentException("Invalid total number of double rooms");
                }
                if (request.getUtility() == null || request.getUtility().isEmpty()) {
                        throw new IllegalArgumentException("Invalid utilities");
                }
                if (request.getProfileImage() == null || request.getProfileImage().isEmpty()) {
                        throw new IllegalArgumentException("Invalid profile image");
                }
                if (request.getImages() == null || request.getImages().isEmpty()) {
                        throw new IllegalArgumentException("Invalid images provided");
                }
                if (request.getNsfasDocument() == null || request.getNsfasDocument().isEmpty()) {
                        throw new IllegalArgumentException("Invalid document provided");
                }

                // Regex validation for Email

                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
                                + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                Pattern pattern = Pattern.compile(emailRegex);

                if (!pattern.matcher(request.getEmail()).matches()) {
                        throw new IllegalArgumentException("Invalid Email address");
                }

                // Regex validation for Fullname

                String fullnameRegex = "^[a-zA-Z\\s'-]{3,50}$";

                Pattern fullnamePattern = Pattern.compile(fullnameRegex);

                if (!fullnamePattern.matcher(request.getFullname()).matches()) {
                        throw new IllegalArgumentException("Invalid FullName address");
                }

                // Regex validation for Slogan

                String sloganRegex = "^(?!\\d+$)[a-zA-Z0-9\\s'-]{3,50}$";

                Pattern sloganPattern = Pattern.compile(sloganRegex);

                if (!sloganPattern.matcher(request.getSlogan()).matches()) {
                        throw new IllegalArgumentException("Invalid Slogan address");
                }

                // Regex validation for Password

                String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

                Pattern passwordPattern = Pattern.compile(passwordRegex);

                if (!passwordPattern.matcher(request.getPassword()).matches()) {
                        throw new IllegalArgumentException("Invalid Password address");
                }

                // Regex validation for ResidenceName

                String resRegex = "^[a-zA-Z0-9\\s'-]{3,50}$";

                Pattern resPattern = Pattern.compile(resRegex);

                if (!resPattern.matcher(request.getName()).matches()) {
                        throw new IllegalArgumentException("Invalid Residence Name address");
                }
                // Regex validation for Utility

                String utilityRegex = "^[a-zA-Z0-9\\s'-]{3,50}$";
                Pattern utilityPattern = Pattern.compile(utilityRegex);

                ArrayList<String> utilities = (ArrayList<String>) request.getUtility();
                for (String utility : utilities) {
                        if (!utilityPattern.matcher(utility).matches()) {
                                throw new IllegalArgumentException("Invalid Utility name: " + utility);
                        }
                }

                // Regex validator for phone number

                String phoneRegex = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$";
                Pattern phonePattern = Pattern.compile(phoneRegex);

                if (!phonePattern.matcher(request.getPhoneNumber()).matches()) {
                        throw new IllegalArgumentException("Invalid Phone Number");
                }

                // Register Admin
                var admin = Admin.builder()
                                .fullname(request.getFullname())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .name(request.getName())
                                .slogan(request.getSlogan())
                                .regNo(request.getRegNo())
                                .phoneNumber(request.getPhoneNumber())
                                .totalNumberOfRooms(request.getTotalNumberOfRooms())
                                .totalNumberOfSingleRooms(request.getTotalNumberOfSingleRooms())
                                .totalNumberOfDoubleRooms(request.getTotalNumberOfDoubleRooms())
                                .utility(request.getUtility())
                                .profileImage(request.getProfileImage())
                                .images(request.getImages())
                                .nsfasDocument(request.getNsfasDocument())
                                .role(Role.ADMIN)
                                .build();
                adminRepository.save(admin);

                var jwtToken = jwtService.generateToken(admin);

                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();

        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {

                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                request.getEmail(), request.getPassword()));

                var user = adminRepository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(user);

                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

}
