package centauri.academy.cerepro.persistence.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import centauri.academy.cerepro.persistence.entity.Candidate;
import centauri.academy.cerepro.persistence.entity.CandidateStates;
import centauri.academy.cerepro.persistence.entity.CoursePage;
import centauri.academy.cerepro.persistence.entity.Employee;
import centauri.academy.cerepro.persistence.entity.Interview;
import centauri.academy.cerepro.persistence.entity.ItConsultant;
import centauri.academy.cerepro.persistence.entity.NewsLetterMessage;
import centauri.academy.cerepro.persistence.entity.NoteTemplate;
import centauri.academy.cerepro.persistence.entity.OriginSite;
import centauri.academy.cerepro.persistence.entity.Question;
import centauri.academy.cerepro.persistence.entity.Role;
import centauri.academy.cerepro.persistence.entity.Survey;
import centauri.academy.cerepro.persistence.entity.SurveyInterview;
import centauri.academy.cerepro.persistence.entity.SurveyQuestion;
import centauri.academy.cerepro.persistence.entity.SurveyReply;
import centauri.academy.cerepro.persistence.entity.Trainee;
import centauri.academy.cerepro.persistence.entity.User;
import centauri.academy.cerepro.persistence.entity.UserTokenSurvey;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;
import centauri.academy.cerepro.persistence.repository.itconsultant.ItConsultantRepository;
import centauri.academy.cerepro.persistence.repository.originsite.OriginSiteRepository;
import centauri.academy.cerepro.persistence.repository.surveyquestion.SurveyQuestionRepository;
import centauri.academy.cerepro.persistence.repository.surveyreply.SurveyReplyRepository;
import centauri.academy.cerepro.persistence.repository.usersurveytoken.UserSurveyTokenRepository;

/**
 * @author m.franco
 * @author anna
 * @author Daniele Piccinni
 */
public abstract class AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(AbstractRepositoryTest.class);

	@Autowired
	private TraineeRepository traineeRepository;// added by jesus
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private ItConsultantRepository itConsultantRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private SurveyRepository surveyRepository;
	@Autowired
	private SurveyReplyRepository surveyReplyRepository;
	@Autowired
	private UserSurveyTokenRepository userSurveyTokenRepository;
	@Autowired
	private SurveyQuestionRepository surveyQuestionRepository;
	@Autowired
	private CoursePageRepository coursePageRepository;
	@Autowired
	private InterviewRepository interviewRepository;	
	
	@Autowired
	private NoteTemplateRepository NoteTemplateRepository;
	@Autowired
	private CandidateStatesRepository candidateStatesRepository;
	@Autowired
	private OriginSiteRepository originSiteRepository;
	@Autowired
	private SurveyInterviewRepository surveyInterviewRepository;
	@Autowired
	private NewsLetterMessageRepository newsLetterMessageRepository;
	
	protected Role getFakeRole() {
		return getFakeRole(100);
	}

	protected Role getFakeRole(int level) {
		Role role = new Role();
		role.setLabel("admin");
		role.setDescription("administrator");
		role.setLevel(level);
		Role roles = roleRepository.findByLevel(level);
		if (roles == null) {
			roleRepository.save(role);
		}
		return role;
	}

	protected User getFakeUser() {

		return getFakeUser(100);
	}

	protected User getFakeUser(int level) {
		User testUser = new User();
		int random = (int) (Math.random() * 10000);
		testUser.setEmail(random + "pippo@prova.com");
		testUser.setPassword("pippo");
		testUser.setFirstname("pippo");
		testUser.setLastname("prova");
		testUser.setDateOfBirth(LocalDate.parse(("1989-10-21")));
		testUser.setRegdate(LocalDateTime.now());
		testUser.setRole(getFakeRole(level).getLevel());
		testUser.setImgpath("impPippo");
		userRepository.save(testUser);
		return testUser;
	}

	protected Candidate getFakeCandidate() {
		logger.info("getFakeCandidate - START");
		long userId = getFakeUser(Role.JAVA_COURSE_CANDIDATE_LEVEL).getId();
		String code = getFakeCoursePage().getCode();
		long candidateStatesId=getFakeCandidateStates().getId();
		//Candidate testCandidate = new Candidate(userId, code,candidateStatesId);
		LocalDateTime regdate = LocalDateTime.now();
		long insertedBy = userId ;
		String firstname = "Test_Firstname" ;
		String lastname = "Test_Lasstname" ;
		String email = "test@email.com" ;
		LocalDateTime candidacyDateTime = LocalDateTime.now();
		Candidate testCandidate = new Candidate(userId, code,candidateStatesId, email, firstname, lastname, regdate, insertedBy, candidacyDateTime);
		candidateRepository.save(testCandidate);
		return testCandidate;
	}
	
//	protected Candidate getFakeCandidateByCandidacyTimeAndCourseCode(LocalDateTime ldt, String courseCode) {
//		long userId = getFakeUser(Role.JAVA_COURSE_CANDIDATE_LEVEL).getId();
//		long candidateStatesId=getFakeCandidateStates().getId();
//		Candidate testCandidate = new Candidate(userId, courseCode, candidateStatesId);
//		testCandidate.setCandidacyDateTime(ldt);
//		candidateRepository.save(testCandidate);
//		return testCandidate;
//	}
	
	protected Candidate getFakeCandidateByCandidacyTimeAndCourseCode(LocalDateTime ldt, String courseCode) {
		logger.info("getFakeCandidateByCandidacyTimeAndCourseCode - START");
		Candidate testCandidate = getFakeCandidate();
		testCandidate.setCourseCode(courseCode);
		testCandidate.setCandidacyDateTime(ldt);
		candidateRepository.save(testCandidate);
		return testCandidate;
	}
	
	protected SurveyInterview getFakeSurveyInterview() {
		long surveyId = getFakeSurvey().getId();
		long interviewId = getFakeInterview().getId();
		SurveyInterview testSI = new SurveyInterview();
		testSI.setInterviewId(interviewId);
		testSI.setSurveyId(surveyId);
		surveyInterviewRepository.save(testSI);
		return testSI;
	}

	protected ItConsultant getFakeItConsultant() {
		long userId = getFakeUser(Role.ITCONSULTANT_LEVEL).getId();
		ItConsultant current = new ItConsultant(userId);
		itConsultantRepository.save(current);
		return current;
	}

	protected Employee getFakeEmployee() {
		Employee employee = new Employee();
		employee.setUserId(getFakeUser().getId());
		employee.setDomicileCity("Milano");
		employee.setDomicileStreetName("Viale Monza");
		employee.setDomicileHouseNumber("10");
		employee.setMobile("118");
		employee.setCvExternalPath("C://documents/mycv.doc");
		employeeRepository.save(employee);
		return employee;
	}

	protected Survey getFakeSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setDescription("ciccioBello");
		testSurvey.setTime(20L);
		testSurvey.setLabel("pelleDiPesca");
		surveyRepository.save(testSurvey);
		return testSurvey;
	}

	protected Question getFakeQuestion() {
		Question testQuestion = new Question("FakeQuestion");
		questionRepository.save(testQuestion);
		return testQuestion;
	}
	
	protected Interview getFakeInterview() {
		Interview testInterview = new Interview();
		testInterview.setQuestionText("FakeQuestion");
		interviewRepository.save(testInterview);
		return testInterview;
	}

	protected SurveyQuestion getFakeSurveyQuestion() {
		long questionId = getFakeQuestion().getId();
		long surveyId = getFakeSurvey().getId();
		SurveyQuestion testSQ = new SurveyQuestion();
		testSQ.setSurveyId(surveyId);
		testSQ.setQuestionId(questionId);
		surveyQuestionRepository.save(testSQ);
		return testSQ;
	}
	
	

	protected SurveyReply getFakeSurveyReply() {
		SurveyReply testSR = new SurveyReply();
		testSR.setUserId(getFakeUser().getId());
		testSR.setSurveyId(getFakeSurvey().getId());
		testSR.setStarttime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		testSR.setEndtime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		testSR.setAnswers("qualcosa");
		testSR.setPdffilename("qualcosa");
		testSR.setPoints("bravo");
		surveyReplyRepository.save(testSR);
		return testSR;
	}
	
	
	protected UserTokenSurvey getFakeUserTokenSurvey() {
		UserTokenSurvey testUST = new UserTokenSurvey(1l);
		List<User> users = userRepository.findAll();
		if (users.isEmpty())
			testUST.setUserid(getFakeUser().getId());
		else
			testUST.setUserid(users.get(0).getId());
		testUST.setSurveyid(getFakeSurvey().getId());
//		testUST.setGeneratedtoken("AAABBBCCCC");
		testUST.setExpirationdate(LocalDateTime.now());
		userSurveyTokenRepository.save(testUST);
		return testUST;
	}

	protected CoursePage getFakeCoursePageWithCode(String code) {
		CoursePage testCoursePage = new CoursePage();
		int random = (int) (Math.random() * 10000);
		testCoursePage.setTitle("Fake title " + random);
		testCoursePage.setBodyText("FakeBodyText " + random);
		testCoursePage.setFileName("FakeFileName " + random);
		testCoursePage.setCode(code);
		coursePageRepository.save(testCoursePage);
		return testCoursePage;
	}

	protected CoursePage getFakeCoursePage() {
		int random = (int) (Math.random() * 10000);
		return getFakeCoursePageWithCode("FakeFileName " + random);
	}

	protected UserTokenSurvey getFakeUserTokenSurveyExpired() {
		UserTokenSurvey testUST = new UserTokenSurvey(1l);
		List<User> users = userRepository.findAll();
		if (users.isEmpty())
			testUST.setUserid(getFakeUser().getId());
		else
			testUST.setUserid(users.get(0).getId());
		testUST.setSurveyid(getFakeSurvey().getId());
//		testUST.setGeneratedtoken("AAABBBCCCC");
		testUST.setExpirationdate(LocalDateTime.now());
		testUST.setExpired(true);
		userSurveyTokenRepository.save(testUST);
		return testUST;
	}

	protected NoteTemplate getFakeNoteTemplate() {
		NoteTemplate Note = new NoteTemplate();
		Note.setTitle("Inter");
		Note.setContent("dream team");
		NoteTemplateRepository.save(Note);
		return Note;
	}
	
	protected CandidateStates getFakeCandidateStates() {
		CandidateStates  csTest = new CandidateStates();
		List<Role> roles = roleRepository.findAll();
		if(roles.isEmpty()) {
			csTest.setRoleId(getFakeRole().getId());
		}
		else {
			csTest.setRoleId(roles.get(0).getId());
		}
		csTest.setStatusCode(1);
		csTest.setStatusLabel("a status label");
		csTest.setStatusDescription("a status description");
		csTest.setStatusColor("#FF0000");
		candidateStatesRepository.save(csTest);
		return csTest;
	}
	
	protected OriginSite getFakeOriginSite() {
		OriginSite os = new OriginSite();
		os.setLabel("Inter");
		os.setDescription("dream team");
		os.setImgpath("dream team");
		originSiteRepository.save(os);
		return os;
	}
	
	protected NewsLetterMessage getFakeNewsLetterMessage() {
		NewsLetterMessage newsLetterMessage = new NewsLetterMessage();
		newsLetterMessage.setSubject("Fake subject 1");
		newsLetterMessage.setMessage("Fake message 1");
		newsLetterMessageRepository.save(newsLetterMessage);
		return newsLetterMessage;
	}
	
	protected Trainee getFakeTrainee() {
		Trainee tr = new Trainee();
		tr.setEmail("email@mail.com");
		tr.setFirstname("bob");
		tr.setLastname("esponja");
		tr.setPassword("password!!");
		traineeRepository.save(tr);
		return tr;
	}
}
