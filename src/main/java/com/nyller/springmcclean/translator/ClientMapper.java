package com.nyller.springmcclean.translator;

import com.nyller.springmcclean.controller.model.ClientRequest;
import com.nyller.springmcclean.domain.ClientDomain;
import com.nyller.springmcclean.gateway.h2database.model.ClientDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    ClientDomain clientDatabaseToDomain(ClientDatabase clientDatabase);

    ClientDatabase clientDomainToDatabase(ClientDomain clientDomain);

    ClientDomain clientRequestToDomain(ClientRequest clientRequest);
}