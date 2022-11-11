package com.masai.service.travels;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Travels;
import com.masai.exception.TravelsException;
import com.masai.repository.TravelsRepo;
@Service
public class TravelsServiceImpl implements TravelsService{
	@Autowired
	private TravelsRepo repo;

	@Override
	public Travels addTravels(Travels travels) throws TravelsException {
		Optional<Travels> rOptional=repo.findById(travels.getTravelsId());
		if (rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is already available in database");
		}
		return repo.save(travels);
	}
	@Override
	public Travels updateTravels(Travels travels) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<Travels> rOptional=repo.findById(travels.getTravelsId());
		if (!rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is not available in database to update");
		}
		return repo.save(travels);
	}

	@Override
	public Travels removeTravels(int travelId) throws TravelsException {
		Optional<Travels> rOptional=repo.findById(travelId);
		if (!rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is not present in database to remove");
		}
		repo.delete(rOptional.get());
		return rOptional.get();
	}

	@Override
	public Travels searchTravels(int travelId) throws TravelsException {
		Optional<Travels> rOptional=repo.findById(travelId);
		if (!rOptional.isPresent()) {
			throw new TravelsException("This Travelservice is not present in database to show");
		}
		return rOptional.get();
	}

	@Override
	public List<Travels> viewTravels() throws TravelsException {
		List<Travels> list=repo.findAll();
		if (list.isEmpty()) {
			throw new TravelsException("This Travelservice is not present in database to remove");
		}
		return list;
	}
}
