package lod_ref2;

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
		
		ApplicationResult result = applicationValidation.validate(applicant);
		if (result.isSuccess()) {
			result = admissionApplicationDao.persist(applicant);
			if (result.isSuccess()) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				this.register(applicant);
			} else {
				retResult.setMessage(result.getMessage());
			}
		} else {
			retResult.setMessage(result.getMessage());
		}
		return retResult;
	}

	
	private ApplicationDao getApplicationDao() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
