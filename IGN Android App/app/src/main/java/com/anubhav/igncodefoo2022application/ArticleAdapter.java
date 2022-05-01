package com.anubhav.igncodefoo2022application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private ArrayList<Article> articleList;
    private Context context;

    public ArticleAdapter(ArrayList<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.setHeadline(article.getMetaData().getHeadline());
        holder.setDescription(article.getMetaData().getDescription());
        holder.setAuthor(article.getAuthors().get(position).getName());
        holder.setProfileImage(article.getAuthors().get(position).getThumbnail());
        holder.setImage(article.getThumbnails().get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView headline, description, author;
        private ImageView image;
        private CircleImageView profileImage;

        public ArticleViewHolder(View view) {
            super(view);

            headline = view.findViewById(R.id.articleTitle);
            description = view.findViewById(R.id.articleDescription);
            author = view.findViewById(R.id.articleAuthor);
            image = view.findViewById(R.id.articleImage);
            profileImage = view.findViewById(R.id.articleProfileImage);
        }

        public void setHeadline(String str) {
            headline.setText(str);
        }

        public void setDescription(String str) {
            description.setText(str);
        }

        public void setAuthor(String str) {
            author.setText(str);
        }

        public void setImage(String str) {
            Picasso.get().load(str).into(image);
        }

        public void setProfileImage(String str) {
            Picasso.get().load(str).into(profileImage);
        }
    }
}
