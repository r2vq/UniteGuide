package ca.keaneq.domain.usecase

import ca.keaneq.domain.model.HeldItem
import ca.keaneq.domain.model.Resource
import ca.keaneq.domain.model.toDomain
import ca.keaneq.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import ca.keaneq.repository.model.Resource as RepoResource

class GetHeldItemUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(id: String): Flow<Resource<HeldItem>> = flow {
        emit(Resource.Loading())
        val result = repository.getHeldItems()
        val emission = if (result is RepoResource.Success) {
            result
                .data
                ?.firstOrNull { item -> item.id == id }
                ?.toDomain()
                ?.let { item -> Resource.Success(item) }
                ?: run { Resource.Error("No matching held item found") }
        } else {
            Resource.Error(result.exception?.toString() ?: "Error occurred in use case.")
        }
        emit(emission)
    }
}