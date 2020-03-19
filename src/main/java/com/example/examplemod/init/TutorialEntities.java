package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.event.RegistryEvent;

public class TutorialEntities{
    public static EntityType<?> TUTORIAL_ENTITY;
    public static Item tutorial_entity_egg;
    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event){
        
        event.getRegistry().registerAll(
            tutorial_entity_egg = registerEntitySpawnEgg(TUTORIAL_ENTITY, 0, 0x00FF00, "tutorial_entity_egg")
        );
    }
    public static void registerEntityWorldSpawns(){
        registerEntityWorldSpawn(TUTORIAL_ENTITY,EntityClassification.CREATURE,Biomes.PLAINS,Biomes.BEACH,Biomes.FOREST);
    }
    public static Item registerEntitySpawnEgg(EntityType<?> type,int primaryColorIn,int secondaryColorIn,String name){
        SpawnEggItem item = new SpawnEggItem(type,primaryColorIn,
            secondaryColorIn,
            new Item.Properties().group(new ItemGroup("tutorial"){
         
             @Override
             public ItemStack createIcon() {
                 // TODO Auto-generated method stub
                 return null;
             }
         }));
        item.setRegistryName(ExampleMod.getId(name));
        return item;
    }
    public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome... biomes){
        for(Biome biome : biomes){
            if(biome != null){
                biome.getSpawns(classification).add(new SpawnListEntry(entity,10,1,10));
            }
        }
    }
}