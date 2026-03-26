package com.global.hr.base;




public class BaseService <T extends BaseEntity , ID>{
    protected BaseRepository<T, ID> baseRepository;

    public BaseService(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }
	
	public T createEmployee(T emp) {
		return baseRepository.save(emp);
	}
}
