package com.example.testmarvel.ui.character

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.testmarvel.R
import com.example.testmarvel.databinding.CharacterItemBinding
import com.example.testmarvel.domain.character.model.Character
import com.example.testmarvel.ui.common.RecyclerViewClickListener
import com.example.testmarvel.ui.common.extensions.replaceByUrlSecure
import retrofit2.http.Url

class CharacterAdapter(private val characters: List<Character>, private val listener: RecyclerViewClickListener, private val context: Context) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CharacterViewHolder(
                    DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.character_item,
                            parent,
                            false
                    )
            )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.itemBinding.character = characters[position]

        holder.itemBinding.characterCard.setOnClickListener{
            listener.onRecyclerViewItemClick(it, characters[position])
        }

        val characterImage = ImageView(context)
        characterImage.scaleType = ImageView.ScaleType.FIT_XY
        holder.itemBinding.apply {
            var secureUrlImage = character?.thumbnail.toString().replaceByUrlSecure()
            downloadAndShowImage(characterImage, secureUrlImage)
            linearCharacter.addView(characterImage)

        }

    }

    private fun downloadAndShowImage(thumbnailCharacter: ImageView, url: String) = Glide.with(context)
            .load(url)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .into(thumbnailCharacter)

    inner class CharacterViewHolder(
            val itemBinding: CharacterItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root)

}