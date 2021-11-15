package ca.keaneq.domain.usecase

import ca.keaneq.domain.model.HeldItem
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.model.toDomain
import ca.keaneq.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import ca.keaneq.repository.model.Resource as RepoResource

class GetHeldItemListUseCase @Inject constructor(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<Resource<List<HeldItem>>> = flow {
        emit(Resource.Loading())
        val result = repository.getHeldItems()
        val emission = if (result is RepoResource.Success) {
            result.data
                ?.map { list -> list.toDomain() }
                .let { list -> Resource.Success(list ?: emptyList()) }
        } else {
            Resource.Error(result.exception?.message ?: "An unknown error occurred")
        }
        emit(emission)
    }
}