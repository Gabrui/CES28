package lod_ref3;

public class School {

	public void register(Applicant applicant) {
		// TODO Auto-generated method stub
		
	}

	private ApplicationValidation getApplicationValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationResult recordNewApplicant(Applicant applicant) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = this.getApplicationValidation();
		ApplicationDao admissionApplicationDao = this.getApplicationDao();
		
		if (applicationValidation.validate(applicant)) {
			if (admissionApplicationDao.persist(applicant)) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				this.register(applicant);
			} else {
				retResult.setMessage("Could not persist.");
			}
		} else {
			retResult.setMessage("Could not validate.");
		}
		return retResult;
	}

	
	private ApplicationDao getApplicationDao() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
