package com.yash.helper;

public class QuestionsDBQuery {
	
	private String insertQuestionQuery;
	private String selectAllQuestionQuery;
	private String selectQuestionByIdQuery;
	private String updateQuestionQuery;
	private String deleteQuestionQuery;
	private String selectSpringQuestionsQuery;
	
	public QuestionsDBQuery() {
		super();
	
	}

	

	public QuestionsDBQuery(String insertQuestionQuery, String selectAllQuestionQuery, String selectQuestionByIdQuery,
			String updateQuestionQuery, String deleteQuestionQuery, String selectSpringQuestionsQuery) {
		super();
		this.insertQuestionQuery = insertQuestionQuery;
		this.selectAllQuestionQuery = selectAllQuestionQuery;
		this.selectQuestionByIdQuery = selectQuestionByIdQuery;
		this.updateQuestionQuery = updateQuestionQuery;
		this.deleteQuestionQuery = deleteQuestionQuery;
		this.selectSpringQuestionsQuery = selectSpringQuestionsQuery;
	}



	public String getInsertQuestionQuery() {
		return insertQuestionQuery;
	}

	public void setInsertQuestionQuery(String insertQuestionQuery) {
		this.insertQuestionQuery = insertQuestionQuery;
	}

	public String getSelectAllQuestionQuery() {
		return selectAllQuestionQuery;
	}

	public void setSelectAllQuestionQuery(String selectAllQuestionQuery) {
		this.selectAllQuestionQuery = selectAllQuestionQuery;
	}

	public String getSelectQuestionByIdQuery() {
		return selectQuestionByIdQuery;
	}

	public void setSelectQuestionByIdQuery(String selectQuestionByIdQuery) {
		this.selectQuestionByIdQuery = selectQuestionByIdQuery;
	}

	public String getUpdateQuestionQuery() {
		return updateQuestionQuery;
	}

	public void setUpdateQuestionQuery(String updateQuestionQuery) {
		this.updateQuestionQuery = updateQuestionQuery;
	}

	public String getDeleteQuestionQuery() {
		return deleteQuestionQuery;
	}

	public void setDeleteQuestionQuery(String deleteQuestionQuery) {
		this.deleteQuestionQuery = deleteQuestionQuery;
	}
	
	

	public String getSelectSpringQuestionsQuery() {
		return selectSpringQuestionsQuery;
	}



	public void setSelectSpringQuestionsQuery(String selectSpringQuestionsQuery) {
		this.selectSpringQuestionsQuery = selectSpringQuestionsQuery;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deleteQuestionQuery == null) ? 0 : deleteQuestionQuery.hashCode());
		result = prime * result + ((insertQuestionQuery == null) ? 0 : insertQuestionQuery.hashCode());
		result = prime * result + ((selectAllQuestionQuery == null) ? 0 : selectAllQuestionQuery.hashCode());
		result = prime * result + ((selectQuestionByIdQuery == null) ? 0 : selectQuestionByIdQuery.hashCode());
		result = prime * result + ((selectSpringQuestionsQuery == null) ? 0 : selectSpringQuestionsQuery.hashCode());
		result = prime * result + ((updateQuestionQuery == null) ? 0 : updateQuestionQuery.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionsDBQuery other = (QuestionsDBQuery) obj;
		if (deleteQuestionQuery == null) {
			if (other.deleteQuestionQuery != null)
				return false;
		} else if (!deleteQuestionQuery.equals(other.deleteQuestionQuery))
			return false;
		if (insertQuestionQuery == null) {
			if (other.insertQuestionQuery != null)
				return false;
		} else if (!insertQuestionQuery.equals(other.insertQuestionQuery))
			return false;
		if (selectAllQuestionQuery == null) {
			if (other.selectAllQuestionQuery != null)
				return false;
		} else if (!selectAllQuestionQuery.equals(other.selectAllQuestionQuery))
			return false;
		if (selectQuestionByIdQuery == null) {
			if (other.selectQuestionByIdQuery != null)
				return false;
		} else if (!selectQuestionByIdQuery.equals(other.selectQuestionByIdQuery))
			return false;
		if (selectSpringQuestionsQuery == null) {
			if (other.selectSpringQuestionsQuery != null)
				return false;
		} else if (!selectSpringQuestionsQuery.equals(other.selectSpringQuestionsQuery))
			return false;
		if (updateQuestionQuery == null) {
			if (other.updateQuestionQuery != null)
				return false;
		} else if (!updateQuestionQuery.equals(other.updateQuestionQuery))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionsDBQuery [insertQuestionQuery=" + insertQuestionQuery + ", selectAllQuestionQuery="
				+ selectAllQuestionQuery + ", selectQuestionByIdQuery=" + selectQuestionByIdQuery
				+ ", updateQuestionQuery=" + updateQuestionQuery + ", deleteQuestionQuery=" + deleteQuestionQuery
				+ ", selectSpringQuestionsQuery=" + selectSpringQuestionsQuery + "]";
	}
}
